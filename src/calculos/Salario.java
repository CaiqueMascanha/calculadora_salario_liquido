package calculos;

public class Salario {
    private double salarioBruto;
    private double descontosInss;
    private double descontoIrpf;
    private double salarioLiquido;

    public Salario(double salarioBruto) {
        this.salarioBruto = salarioBruto;
        calculadoraInss();
        calculadoraIrpf();
        this.salarioLiquido = this.salarioBruto - this.descontosInss - this.descontoIrpf;
    }

    public double getSalarioBruto() {
        return salarioBruto;
    }

    public String getDescontosInss() {
        return String.format("%.2f", this.descontosInss);
    }

    public String getdescontoIrpf() {
        return String.format("%.2f", this.descontoIrpf);
    }

    private void calculadoraInss() {
        if (this.salarioBruto <= 1412.0) {
            this.descontosInss = this.salarioBruto * 0.075;

        } else if (this.salarioBruto >= 1412.01 && this.salarioBruto <= 2666.68) {
            this.descontosInss = (this.salarioBruto * 0.09) - 21.18;

        } else if (this.salarioBruto >= 2666.69 && this.salarioBruto <= 4000.03) {
            this.descontosInss = (this.salarioBruto * 0.12) - 101.18;

        } else {
            this.descontosInss = (this.salarioBruto * 0.14) - 181.18;
        }
        if (this.descontosInss > 908.8627) {
            this.descontosInss = 908.8628;
        }
    }

    private void calculadoraIrpf() {
        if (this.salarioBruto > 2112.0 && this.salarioBruto <= 2826.65) {
            this.descontoIrpf = ((this.salarioBruto - this.descontosInss) * 0.075) - 158.40;

        } else if (this.salarioBruto >= 2826.66 && this.salarioBruto <= 3751.05) {
            this.descontoIrpf = ((this.salarioBruto - this.descontosInss) * 0.15) - 370.40;

        } else if (this.salarioBruto >= 3751.06 && this.salarioBruto <= 4664.68) {
            this.descontoIrpf = ((this.salarioBruto - this.descontosInss) * 0.225) - 651.73;

        } else if (this.salarioBruto > 4664.68){
            this.descontoIrpf = ((this.salarioBruto - this.descontosInss) * 0.275) - 884.96;
        }
        else {
            this.descontoIrpf = 0;
        }
    }

    @Override
    public String toString() {
        return "Seu salário bruto de " + String.format("%.2f", this.salarioBruto) + " \nterá um desconto do INSS de " + String.format("%.2f",this.descontosInss) + " \ne do irpf " + String.format("%.2f",this.descontoIrpf) + " \ntotalizando liquido de: " + String.format("%.2f",this.salarioLiquido);
    }
}
