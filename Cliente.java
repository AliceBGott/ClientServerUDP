import java.net.*; // for DatagramSocket,DatagramPacket,InetAddress
import java.io.*; // for IOException
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;



//ip do server é o ip da maquina
//usar port = 7000
//close no final



public class Cliente{

    
    public static void main (String[] args) throws IOException {
        InetAddress serverAddress = InetAddress.getByName("localhost"); //endereco
        int servPort = 7000; // Porta 

        DatagramSocket socket = new DatagramSocket();
        Scanner scanner = new Scanner(System.in);


        System.out.println("Digite 1 para Data ou 2 para Hora:");
        String message = scanner.nextLine();

        byte[] bytesToSend = message.getBytes();

        DatagramPacket packetToSend = new DatagramPacket(bytesToSend, bytesToSend.length, serverAddress, servPort);
        socket.send(packetToSend);

        byte[] bufferAnswer = new byte[255];
        DatagramPacket packetAnswer = new DatagramPacket(bufferAnswer, bufferAnswer.length);
        socket.receive(packetAnswer);

        String answer = new String(packetAnswer.getData(), 0, packetAnswer.getLength());
        System.out.println("Resposta do servidor: " + answer);

        socket.close();

    }


}

/*
define endereço
define porta
cria buffer da mensagem
cria socket
cria scanner
lê mensagem
cria packet
envia mensagem com socket.send()
buffer resposta
cira packet resposta
socket.receive(resposta)
printa resposta do servidor
fecha socket


 */
