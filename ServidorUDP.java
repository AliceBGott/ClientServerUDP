import java.net.*; // for DatagramSocket,DatagramPacket,InetAddress
import java.io.*; // for IOException
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;


public class ServidorUDP{

    public static void main (String[] args) throws IOException {
        int servPort = 7000; //porta

        byte[] buffer = new byte[255];

        DatagramSocket socket = new DatagramSocket();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);




        while(true){
            socket.receive(packet); //recebe mensagem
            String message = new String(packet.getData(), 0, packet.getLength()); //extrai mensagem

            String answer;//cria string de resposta

             if("1".equals(message)){
                answer = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
             }else if ("2".equals(message)){
                answer = new SimpleDateFormat("HH:mm:ss").format(new Date());
             }else{
                answer = "Comando iválido.";
             }
             
             //devolve resposta com método send() do socket
             byte[] bufferAnswer =answer.getBytes();
             DatagramPacket packetAnswer = new DatagramPacket(bufferAnswer, bufferAnswer.length, packet.getAddress(), packet.getPort());
             socket.send(packetAnswer);



        }

    }
}

/*
define porta
cria socket
cria packet
cria buffer de bytes pra armazenar dados recebidos
loop principal: 
    socket.receive(mensagem)
    extrai mensagem
    cria string de resposta
    se 1: devolve data
    se 2: devolve hora
    else: código inválido
devolve resposta com método send() do socket
cria buffer de resposta
cria packet de resposta
devolve resposta

*/
