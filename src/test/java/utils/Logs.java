package utils;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Logs {

    String dataHora;

    public void iniciarLogCSV(String dataHora ) throws IOException {
        String[] cabecalho = {"data e hora" , "caso de teste" , "mensagem"};
        this.dataHora = dataHora;
        Writer escritor = Files.newBufferedWriter(Paths.get("target/logs/log - " + dataHora + ".csv"));
        CSVWriter escritorCSV = new CSVWriter(escritor);

        escritorCSV.writeNext(cabecalho);

        escritorCSV.flush();
        escritor.close();
    }


    public void registrarCSV(String casoDeTeste , String mensagem) throws IOException {
        String dataHoraLog = new SimpleDateFormat("[yyyy/MM/dd HH:mm:ss] ").format(Calendar.getInstance().getTime());

        List<String[]> linhas = new ArrayList<>();

        linhas.add(new String[]{dataHoraLog,casoDeTeste,mensagem});

        //Writer escritor = Files.newBufferedWriter(Paths.get("target/logs/log - " + dataHora + ".csv"));
        FileWriter escritor = new FileWriter("target/logs/log - " + dataHora + ".csv",true);

        CSVWriter escritorCSV = new CSVWriter(escritor);

        escritorCSV.writeAll(linhas);

        escritorCSV.flush();
        escritor.close();
    }

}
