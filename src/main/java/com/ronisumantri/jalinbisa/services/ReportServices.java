package com.ronisumantri.jalinbisa.services;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportServices {
    private static final String directoryPath = System.getProperty("user.dir") + "/src/output/";
    public static void processFile() {
        try {
            String currentDirectory = System.getProperty("user.dir");
            String relativePath = Paths.get(currentDirectory, "src/config", "config.txt").toString();
            List<String> lines = Files.readAllLines(Paths.get(relativePath));
            String directoryPath = Paths.get(currentDirectory, "src/output").toString();

            List<Map<String, String>> listBank = new ArrayList<>();
            Map<String, List<Map<String, String>>> acquirerIssuer = new HashMap<>();

            for (String line : lines) {
                processBankInfo(line, listBank, directoryPath);
                acquirerIssuerInfo(line, acquirerIssuer);
            }

            printResults(listBank, acquirerIssuer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void processBankInfo(String line, List<Map<String, String>> listBank, String directoryPath) throws IOException {
        if (line.contains(";")) {
            String[] parts = line.split(";|:");
            String code = parts[0].trim();
            String codeNumber = parts[1].trim();
            String bankName = parts[2].trim();

            Map<String, String> bankMap = new HashMap<>();
            bankMap.put("code", code);
            bankMap.put("codeNumber", codeNumber);
            bankMap.put("bank", bankName);

            listBank.add(bankMap);

            String directoryFolder = Paths.get(directoryPath, code).toString();

            if (!Files.exists(Paths.get(directoryFolder))) {
                Files.createDirectory(Paths.get(directoryFolder));
                System.out.println("Directory \"" + code + "\" created.");
            } else {
                System.out.println("Directory \"" + code + "\" already exists.");
            }
        }
    }

    private static void acquirerIssuerInfo(String line, Map<String, List<Map<String, String>>> acquirerIssuer) {
        if (line.contains("=")) {
            String[] keyValue = line.split("=");
            String key = keyValue[0].trim();
            String[] values = keyValue[1].trim().split(",");

            List<Map<String, String>> trimmedValues = new ArrayList<>();
            for (String value : values) {
                Map<String, String> valueMap = new HashMap<>();
                valueMap.put("value", value.trim());
                trimmedValues.add(valueMap);
            }

            acquirerIssuer.put(key, trimmedValues);
        }
    }

    private static void printResults(List<Map<String, String>> listBank, Map<String, List<Map<String, String>>> acquirerIssuer) {
        List<Map<String, String>> acquirer = acquirerIssuer.get("ACQUIRER");
        List<Map<String, String>> issuer = acquirerIssuer.get("ISSUER");
        for (Map<String, String> bank : listBank) {
            String code = bank.get("code");
            if (acquirer.stream().anyMatch(acq -> acq.get("value").equals(code))
                    && issuer.stream().anyMatch(iss -> iss.get("value").equals(code))) {
                Map<String, String> templateData = new HashMap<>();
                templateData.put("BANK_NAME", bank.get("bank"));
                templateData.put("ISSUER", bank.get("bank"));

                String template = templateSource;
                for (Map.Entry<String, String> entry : templateData.entrySet()) {
                    template = template.replace("{{ " + entry.getKey() + " }}", entry.getValue());
                }

                String filePath = Paths.get(directoryPath, code, code + ".html").toString();

                try {
                    Files.createDirectories(Paths.get(directoryPath, code));
                    Files.write(Paths.get(filePath), template.getBytes());
                    System.out.println("Report " + code + " printed");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Bank not listed in ACQUIRER or ISSUER");
            }
        }
    }


    private static final String templateSource = """
        <table border="0" cellpadding="1" cellspacing="1" style="width:1400px">
            <tbody>
                <tr>
                    <td style="width:248px">RETENSI&nbsp; &nbsp;&nbsp;: AA.18&nbsp; &nbsp;</td>
                    <td style="width:511px">LAPORAN BIAYA TRANSAKSI EFT SWITCHING (ATM-PAYMENT)&nbsp;</td>
                    <td style="width:223px">FREKUENSI : HARIAN</td>
                </tr>
                <tr>
                    <td style="width:248px">LAPORAN : PI02</td>
                    <td style="width:511px">ACQUIRER: {{ BANK_NAME }}</td>
                    <td style="width:223px">TANGGAL : 27-10-22</td>
                </tr>
                <tr>
                    <td style="width:248px">&nbsp;</td>
                    <td style="width:511px">&nbsp;</td>
                    <td style="width:223px">HALAMAN : 1</td>
                </tr>
                <tr>
                    <td style="width:248px">ISSUER&nbsp; &nbsp; &nbsp; &nbsp;:{{ ISSUER }}</td>
                    <td style="width:511px">&nbsp;</td>
                    <td style="width:223px">&nbsp;</td>
                </tr>
                <tr>
                    <td style="width:248px">&nbsp;</td>
                    <td style="width:511px">&nbsp;</td>
                    <td style="width:223px">&nbsp;</td>
                </tr>
            </tbody>
        </table>
        """;
}
