package com.sd.locacao;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ClienteRMI {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1085);
            Locacao locacao = (Locacao) registry.lookup("LocacaoService");

            Cliente cliente = new Cliente("Carlos Silva", "12345678900");   
            ObjectMapper objectMapper = new ObjectMapper();
            String clienteJson = objectMapper.writeValueAsString(cliente);
            locacao.cadastrarClienteJson(clienteJson);
            System.out.println("Cliente cadastrado com sucesso!");

            Aparelho gerador = new Gerador("Gerador 5000W", 150.0);
            String geradorJson = objectMapper.writeValueAsString(gerador);
            locacao.cadastrarAparelhoJson(geradorJson);

            Aparelho palco = new Palco("Palco Grande", 500.0);
            String palcoJson = objectMapper.writeValueAsString(palco);
            locacao.cadastrarAparelhoJson(palcoJson);

            System.out.println("Aparelhos cadastrados com sucesso!");

            String aparelhosJson = locacao.listarAparelhosJson();
            System.out.println("JSON recebido no cliente: " + aparelhosJson);
            List<Aparelho> aparelhos = objectMapper.readValue(aparelhosJson,
                objectMapper.getTypeFactory().constructCollectionType(List.class, Aparelho.class));
            System.out.println("Aparelhos disponíveis para locação:");
            for (Aparelho a : aparelhos) {
                System.out.println(a.getNome() + " - R$ " + a.getPrecoLocacao());
            }
            
            String valorLocacaoJson = locacao.calcularLocacaoJson(geradorJson, 3);
            double valorLocacao = objectMapper.readValue(valorLocacaoJson, Double.class);
            System.out.println("Valor da locação do " + gerador.getNome() + " por 3 dias: R$ " + valorLocacao);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}