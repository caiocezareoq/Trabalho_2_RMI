package com.sd.locacao;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class ClienteRMI {
    public static void main(String[] args) {
        try {
           
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

          
            Locacao locacao = (Locacao) registry.lookup("LocacaoService");

            
            Cliente cliente = new Cliente("Carlos Silva", "12345678900");
            locacao.cadastrarCliente(cliente);
            System.out.println("Cliente cadastrado com sucesso!");

            
            Aparelho gerador = new Gerador("Gerador 5000W", 150.0);
            Aparelho palco = new Palco("Palco Grande", 500.0);
            Aparelho mesas = new Mesas("Mesa(unidade)", 30.0);
            Aparelho talheres = new Palco("Talheres(unidade)", 20.0);
            locacao.cadastrarAparelho(gerador);
            locacao.cadastrarAparelho(palco);
            locacao.cadastrarAparelho(mesas);
            locacao.cadastrarAparelho(talheres);
            System.out.println("Aparelhos cadastrados com sucesso!");

         
            List<Aparelho> aparelhos = locacao.listarAparelhos();
            System.out.println("Aparelhos disponíveis para locação:");
            for (Aparelho a : aparelhos) {
                System.out.println(a.getNome() + " - R$ " + a.getPrecoLocacao());
            }

            double valorLocacao = locacao.calcularLocacao(gerador, 3);
            System.out.println("Valor da locação do " + gerador.getNome() + " por 3 dias: R$ " + valorLocacao);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
