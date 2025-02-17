package com.sd.locacao;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LocacaoImpl extends UnicastRemoteObject implements Locacao {
    private List<Cliente> clientes;
    private List<Aparelho> aparelhos;
    private ObjectMapper objectMapper;

    public LocacaoImpl() throws RemoteException {
        clientes = new ArrayList<>();
        aparelhos = new ArrayList<>();
        objectMapper = new ObjectMapper();
    }

    @Override
    public void cadastrarClienteJson(String clienteJson) throws RemoteException {
        try {
            Cliente cliente = objectMapper.readValue(clienteJson, Cliente.class);
            clientes.add(cliente);
        } catch (Exception e) {
            throw new RemoteException("Erro ao desserializar cliente", e);
        }
    }

    @Override
    public void cadastrarAparelhoJson(String aparelhoJson) throws RemoteException {
        try {
            Aparelho aparelho = objectMapper.readValue(aparelhoJson, Aparelho.class);
            aparelhos.add(aparelho);
        } catch (Exception e) {
            throw new RemoteException("Erro ao desserializar aparelho", e);
        }
    }

    @Override
    public String listarAparelhosJson() throws RemoteException {
        try {
            String json = objectMapper.writeValueAsString(aparelhos);

            System.out.println("JSON gerado no servidor: " + json); // Log do JSON gerado
            return json;
        } catch (Exception e) {
            throw new RemoteException("Erro ao serializar aparelhos", e);
        }
    }

    @Override
    public String calcularLocacaoJson(String aparelhoJson, int dias) throws RemoteException {
        try {
            Aparelho aparelho = objectMapper.readValue(aparelhoJson, Aparelho.class);
            double valor = aparelho.getPrecoLocacao() * dias;
            return objectMapper.writeValueAsString(valor);
        } catch (Exception e) {
            throw new RemoteException("Erro ao calcular locação", e);
        }
    }
}