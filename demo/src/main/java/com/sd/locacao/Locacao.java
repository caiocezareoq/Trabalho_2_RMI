package com.sd.locacao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Locacao extends Remote {
    void cadastrarCliente(Cliente cliente) throws RemoteException;
    void cadastrarAparelho(Aparelho aparelho) throws RemoteException;
    List<Aparelho> listarAparelhos() throws RemoteException;
    double calcularLocacao(Aparelho aparelho, int dias) throws RemoteException;
}

