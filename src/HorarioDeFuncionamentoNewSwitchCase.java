import java.util.Scanner;

public class HorarioDeFuncionamentoNewSwitchCase {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Qual dia deseja ser atendido(a)? Informe com as 3 primeiras letras do dia da semana. Ex.: seg (Segunda) \n");
        System.out.print("> ");
        String diaInformado = sc.nextLine().toUpperCase();

        System.out.print("Escolha o mês para o atendimento. Informando (1 - janeiro, 2 - fevereiro) ");
        System.out.print("> ");
        String mesInformado = sc.nextLine().toUpperCase();

        boolean erro = false;

        int mesInformadoConvertido = 0;

        try {
            mesInformadoConvertido = Integer.parseInt(mesInformado);
        } catch (NumberFormatException e) {
            System.out.println("Erro fatal, valor(es) não identificado(s).");
        }

        if ((diaInformado.isBlank() || mesInformado.isBlank()) || (diaInformado.isEmpty() || mesInformado.isEmpty()) || (diaInformado.length() > 3)) {
            System.out.println("Inconsistência nas informações.");
            erro = true;
        }


		/*
		String informacao = "";

		switch (diaInformado) {
			case "SEG" -> informacao = "fechado";

			case "TER", "QUA", "QUI", "SEX" -> informacao = "08h as 18h";

			case "SAB", "DOM" -> informacao = "08h as 14h";

			default -> informacao = "Informação inválida";

		}
		*/

        // Ou

        boolean atendimento = false;

        String informacao = switch (diaInformado) {
            case "SEG" -> {
                if (mesInformadoConvertido == 12) {
                    atendimento = true;
                    yield "Horário de especial de funcionamento, das 08h as 20h";
                } else {
                    yield "fechado";
                }
            }

            case "TER", "QUA", "QUI", "SEX" -> informacao = "08h as 18h";

            case "SAB", "DOM" -> informacao = "08h as 14h";

            // O bloco default é obrigatório, a menos que todos os casos possíveis tenham sido cobertos. Isso garante que a expressão tenha um valor válido em todos os casos.
            default -> informacao = "Informação inválida";
        };


        if (erro) {
            System.out.println("Tivemos um problema.");
        } else if (mesInformadoConvertido < 1 || mesInformadoConvertido > 12) {
            informacao = "mês inválido";
            System.out.println(informacao);
        } else if ((diaInformado.equals("SEG") && mesInformadoConvertido != 12)) {
            System.out.printf("O estabelecimento encontra-se %s%n", informacao);
        } else if (diaInformado.equals("TER") || diaInformado.equals("QUA") || diaInformado.equals("QUI")
                || diaInformado.equals("SEX") || diaInformado.equals("SAB") || diaInformado.equals("DOM")) {
            System.out.printf("Horário de atendimento ( %s ) %n", informacao);
            atendimento = true;
        } else {
            System.out.println(informacao);
        }

        if ((!atendimento)) {
            System.out.println("Finalizando...");
        } else {
            System.out.println("Aguardamos sua visita, até logo... ");
        }

    }

}
