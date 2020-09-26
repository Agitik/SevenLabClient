package NetworkExchange;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Класс, реализующий сетевой обмен сервера и клиенте
 * @author Dima Tolochek
 * @version 1.0 Before Check
 */

public class Client {
    /**
     * Отправка запроса на сервер и получение ответа
     * @param pack запрос
     * @param adress адрес сервера
     * @param port порт подключения
     */
    public static AnswerPack sendToServerAndGetAnswer(QuestionPack pack, String adress, Integer port){
        AnswerPack ap = new AnswerPack();
        try {
            //Подключение
            SocketAddress a = new InetSocketAddress(adress, port);
            SocketChannel s = SocketChannel.open(a);

            //Отправка запроса
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(pack);

            byte[] data = baos.toByteArray();

            s.write(ByteBuffer.wrap(data));

            //Получение ответа
            ByteBuffer f = ByteBuffer.allocate(1024*1024);
            f.flip();
            f.compact();
            s.read(f);
            ByteArrayInputStream bais = new ByteArrayInputStream(f.array());
            ObjectInputStream ois = new ObjectInputStream(bais);
            ap = (AnswerPack) ois.readObject();
            UnPacker.UnPackAnswerFromServer(ap.answer);
            s.finishConnect();
            s.close();
        } catch (IOException e) {

            e.printStackTrace(); //дебаг
            System.out.println("Сервер на данном порту не обнаружен!");
            System.out.println("Перезапустите программу с указанием корректных данных.");
            ClientMain.exitCode = true;
        } catch (ClassNotFoundException e) {
            System.out.println("Ответ не удалось распаковать!");
        }
        return ap;
    }
}