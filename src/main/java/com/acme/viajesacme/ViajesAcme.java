/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

 package com.acme.viajesacme;

 import javax.swing.*;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 
 import com.acme.viajesacme.avion.application.CreateAvionUseCase;
 import com.acme.viajesacme.avion.domain.service.AvionService;
 import com.acme.viajesacme.avion.infrastructure.in.AvionController;
 import com.acme.viajesacme.avion.infrastructure.out.AvionRepository;
import com.acme.viajesacme.persona.application.ClienteUseCase;
import com.acme.viajesacme.persona.domain.service.ClienteService;
import com.acme.viajesacme.persona.infrastructure.in.ClienteController;
import com.acme.viajesacme.persona.infrastructure.out.ClienteRepository;
import com.acme.viajesacme.vuelo.application.CreateVueloUseCase;
 import com.acme.viajesacme.vuelo.domain.service.VueloService;
 import com.acme.viajesacme.vuelo.infrastructure.in.VueloController;
 import com.acme.viajesacme.vuelo.infrastructure.out.VueloRepository;
 
 /**
  *
  * @author camper
  */
 public class ViajesAcme {
 
     public static void main(String[] args) {
         SwingUtilities.invokeLater(new Runnable() {
             @Override
             public void run() {
                 JFrame frame = new JFrame("Viajes ACME");
                 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
                 // Crear barra de menú
                 JMenuBar menuBar = new JMenuBar();
 
                 // Crear menú
                 JMenu menu = new JMenu("Casos de Uso");
 
                 // Crear elemento de menú para registro de avión
                 JMenuItem menuItemRegistroAvion = new JMenuItem("Registro de Avion");
                 menuItemRegistroAvion.addActionListener(new ActionListener() {
                     @Override
                     public void actionPerformed(ActionEvent e) {
                         AvionService avionService = new AvionRepository();
                         CreateAvionUseCase createAvionUseCase = new CreateAvionUseCase(avionService);
                         frame.getContentPane().removeAll(); // Elimina componentes actuales
                         frame.getContentPane().add(new AvionController(createAvionUseCase));
                         frame.revalidate();
                         frame.repaint();
                         frame.pack();
                     }
                 });
 
                 // Crear elemento de menú para registro de vuelo
                 JMenuItem menuItemRegistroVuelo = new JMenuItem("Registro de Vuelo");
                 menuItemRegistroVuelo.addActionListener(new ActionListener() {
                     @Override
                     public void actionPerformed(ActionEvent e) {
                         VueloService vueloService = new VueloRepository();
                         CreateVueloUseCase createVueloUseCase = new CreateVueloUseCase(vueloService);
                         frame.getContentPane().removeAll(); // Elimina componentes actuales
                         frame.getContentPane().add(new VueloController(createVueloUseCase));
                         frame.revalidate();
                         frame.repaint();
                         frame.pack();
                     }
                 });

                 // Crear elemento de menu para registro de cliente
                 JMenuItem menuItemRegistroCliente = new JMenuItem("Registro de Cliente");
                 menuItemRegistroCliente.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ClienteService clienteService = new ClienteRepository();
                        ClienteUseCase clienteUseCase  = new ClienteUseCase(clienteService);
                        frame.getContentPane().removeAll(); // Elimina componentes actuales
                        frame.getContentPane().add(new ClienteController(clienteUseCase));
                        frame.revalidate();
                        frame.repaint();
                        frame.pack();
                    }
                 });

 
                 // Agregar elementos de menú al menú
                 menu.add(menuItemRegistroAvion);
                 menu.add(menuItemRegistroVuelo);
                 menu.add(menuItemRegistroCliente);
 
                 // Agregar menú a la barra de menú
                 menuBar.add(menu);
 
                 // Establecer barra de menú en el frame
                 frame.setJMenuBar(menuBar);
 
                 frame.setSize(300, 400); // Tamaño inicial del frame
                 frame.setVisible(true);
             }
         });
     }
 }
 
 

