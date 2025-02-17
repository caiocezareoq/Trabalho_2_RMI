package com.sd.locacao;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ServidorRMI {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1098);

            LocacaoImpl locacao = new LocacaoImpl();
            Naming.rebind("rmi://localhost/LocacaoService", locacao);

            System.out.println("Servidor RMI pronto!");
        } catch (RemoteException | java.net.MalformedURLException e) {
            e.printStackTrace();
        }
    }
}


