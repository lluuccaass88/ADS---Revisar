#include <iostream>
#include <stdio.h>
#include <string.h>

typedef struct Cconta{
		char nome[100];
		int codigo;
		float saldo;
};
Cconta conta[10];
FILE *txt;

void cadastrarCorrentista(int indice){
	int codigoCliente; 
	float saldoCliente;
	char nomeCliente[100];
	
	system("cls");

	printf("\nCodigo: ");
	scanf("%d", &conta[indice].codigo);
	
	getchar();
	
	printf("\nNome: ");
	scanf(" %[^\n]s", &conta[indice].nome);
	
	printf("\nSaldo: ");
	scanf("%f", &conta[indice].saldo);

}

void mostrarCorrentistar(){
    int cont = 0;

    system("cls");

    while(cont < 10){
        if(conta[cont].codigo != 0){
            printf("Codigo : %d \n", conta[cont].codigo);
            printf("Nome : %s \n", conta[cont].nome);
            printf("saldo : %f \n", conta[cont].saldo);
            printf("\n====//====\n\n");
        }
		cont++;
	}

    getchar();
    getchar();
}

void operacaoCorrentista(){
	char opcOperacao;
	int codigo;
	int percorreConta;
	int valor;
	
	system("cls");
	printf("\n=====Operacao=====\n");
	
	printf("Digite o codigo da conta que deseja realiar uma operacao: ");
	scanf("%d", &codigo);
	
	getchar();
	
	printf("\nDigite a operação que deseja realiza: \nDebito (D); Credito(C);");
	scanf("%c", &opcOperacao);

    getchar();

	if(opcOperacao == 'D'){
		for(percorreConta = 0; percorreConta <= 10; percorreConta++){
			if(conta[percorreConta].codigo == codigo){
				printf("Digite o valor: ");
				scanf("%d", &valor);
				conta[percorreConta].saldo = conta[percorreConta].saldo - valor;
			}
		}
	}else if(opcOperacao == 'C'){ //Descobrir o que ele quer aqui
		for(percorreConta = 0; percorreConta <= 10; percorreConta++){
			if(conta[percorreConta].codigo == codigo){
				printf("Digite o valor: ");
				scanf("%d", &valor);
				conta[percorreConta].saldo = conta[percorreConta].saldo + valor;
			}
		}
	}
	
}

void salvar(){
	txt = fopen("contas.txt", "w");
	int contSalvar = 0;
	
    while(contSalvar < 10){
        if(conta[contSalvar].codigo != 0){
            fprintf(txt, "%d ", (conta[contSalvar].codigo));
            fprintf(txt, "%s ", (conta[contSalvar].nome));
            fprintf(txt, "%2.f \n", (conta[contSalvar].saldo));
        } 
        contSalvar++;
	}

	fclose(txt);
}

int primeiraLeitura(int indice){	
			
	if((txt = fopen("contas.txt", "r")) == NULL){
       printf("nem um arquivo encontrado");
   }else{
   	while(fscanf(txt, "%d %s %f", &conta[indice].codigo, &conta[indice].nome, &conta[indice].saldo)!= EOF){
            indice++;
        }
	}

	fclose(txt);

    return indice;
}

int main(int argc, char** argv) {
	int sair = 0;
	int opc;
	int numeroDeContas = 0;

	numeroDeContas = primeiraLeitura(numeroDeContas);

	while(sair == 0){
        system("cls");
		printf("=====Banco=====\n\n");
		printf("Digite a opcao desejada: \n");
		printf("1- Registrar novo correntista; \n2- Mostrar tudo; \n3- Operacao; ");
		scanf("%d", &opc);
		
		if(opc == 1){
			if(numeroDeContas <= 10){
				cadastrarCorrentista(numeroDeContas);
				salvar();
				numeroDeContas++;
			}else{
				printf("\n Numero maximo de correntistas alcancado!");
			}

		}else if(opc == 2){
			mostrarCorrentistar();
		}else if(opc == 3){
			operacaoCorrentista();
            salvar();
		}
	}
	
	return 0;
}
