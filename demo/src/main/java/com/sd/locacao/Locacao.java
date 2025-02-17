package com.sd.locacao;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Locacao extends Remote {
    void cadastrarClienteJson(String clienteJson) throws RemoteException;
    void cadastrarAparelhoJson(String aparelhoJson) throws RemoteException;
    String listarAparelhosJson() throws RemoteException;
    String calcularLocacaoJson(String aparelhoJson, int dias) throws RemoteException;
}

