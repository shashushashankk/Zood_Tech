package com.zoodel.StepGroup;

import com.zoodel.Generic.GlobalVariable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LaunchEmulator extends GlobalVariable {
    String emuName = "";

    @Test
    void launchEmulator() throws IOException {
        emuName = getEmulatorName();
        ProcessBuilder processBuilder = new ProcessBuilder();
        Process result = processBuilder.command("C:\\Users\\ER\\AppData\\Local\\Android\\Sdk\\emulator\\emulator.exe", "-avd", emuName).start();
        BufferedReader br = new BufferedReader(new InputStreamReader(result.getInputStream()));
        String response = "";
//        while ((response = br.readLine()) != null) {
//            System.out.println("Response  is " + response);
//        }
        System.out.println("Response  is " + response);
    }

    String getEmulatorName() throws IOException {
        String emulatorName = "";
        ProcessBuilder processBuilder = new ProcessBuilder();
        Process result = processBuilder.command("C:\\Users\\ER\\AppData\\Local\\Android\\Sdk\\emulator\\emulator.exe", "-list-avds").start();
        BufferedReader br = new BufferedReader(new InputStreamReader(result.getInputStream()));
        String response = "";
        while ((response = br.readLine()) != null) {
            emulatorName = response;
            System.out.println("Emulator name is " + emulatorName);
        }
        result.destroy();
//        log.info("Emulator name is "+emulatorName);
        return emulatorName;
    }
}
