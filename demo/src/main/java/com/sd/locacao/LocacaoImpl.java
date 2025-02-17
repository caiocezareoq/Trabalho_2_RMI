package com.sd.locacao;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class LocacaoImpl extends UnicastRemoteObject implements Locacao {
    private List<Cliente> clientes;
    private List<Aparelho> aparelhos;

    public LocacaoImpl() throws RemoteException {
        clientes = new ArrayList<>();
        aparelhos = new ArrayList<>();
    }

    @Override
    public void cadastrarCliente(Cliente cliente) throws RemoteException {
        clientes.add(cliente);
    }

    @Override
    public void cadastrarAparelho(Aparelho aparelho) throws RemoteException {
        aparelhos.add(aparelho);
    }

    @Override
    public List<Aparelho> listarAparelhos() throws RemoteException {
        return aparelhos;
    }

    @Override
    public double calcularLocacao(Aparelho aparelho, int dias) throws RemoteException {
        return aparelho.getPrecoLocacao() * dias;
    }
}