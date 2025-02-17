package com.sd.locacao;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServidorRMI {
    public static void main(String[] args) {
        try {
            // Cria a instância do serviço de locação
            LocacaoImpl locacaoService = new LocacaoImpl();

            // Não é necessário exportar manualmente, pois LocacaoImpl estende UnicastRemoteObject

            // Cria o registro RMI na porta 1099
            Registry registry = LocateRegistry.createRegistry(1085);

            // Registra o serviço no registro RMI com o nome "LocacaoService"
            registry.rebind("LocacaoService", locacaoService);

            System.out.println("Servidor RMI pronto!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}