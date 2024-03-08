package program;

import calculos.Salario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe seu salário mensal: ");

        double valorMensal = sc.nextDouble();

        Salario salario = new Salario(valorMensal);

        System.out.println(salario);

    }
}