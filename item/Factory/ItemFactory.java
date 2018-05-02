/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item.Factory;

import item.Electrodomestic;
import item.Factory.Computer.Components.*;
import item.Factory.Computer.Computers.*;
import item.Factory.Home.*;
import java.util.ArrayList;

/**
 *
 * @author ashh412
 */
public class ItemFactory {
//1. Vendedor 2. Tecnico 3. Financiero"));

    public static Electrodomestic getElectrodomestic(int ElectroType, String key, ArrayList<String> responseValues) {
        {
            switch (ElectroType) {
//                case 1:
//                    return new IniComputer(key,responseValues );
//
//                case 2:
//                    return new Fridge(key,responseValues );
//
//                case 3:
//                    return new iniPhone(key,responseValues );
//
//                case 4:
//                    return new iniScreen(key,responseValues );
//
//                case 5:
//                    return new iniSound(key,responseValues );
////////////////COMPUTER COMONENTS
                case 31111:
                    return new IniKeyboard(key, responseValues);
                case 31112:
                    return new IniMemory(key, responseValues);

                case 31113:
                    return new IniMouse(key, responseValues);
                case 31114:
                    return new IniPrinter(key, responseValues);

                case 31115:
                    return new IniProcesor(key, responseValues);
                case 31121:
                    return new IniPda(key, responseValues);
                case 31122:
                    return new IniLabtop(key, responseValues);
                case 31123:
                    return new IniDesktop(key, responseValues);
                case 31124:
                    return new IniNoteBook(key, responseValues);
//Fin ordenadores
                case 3121:
                    return new IniDishWasher(key, responseValues);

                case 3122:
                    return new IniFridge(key, responseValues);
                case 3123:
                    return new IniHoover(key, responseValues);
                case 3124:
                    return new IniWashingMachine(key, responseValues);

                //      
//        switch (ElectroType) {
//
//            case 31111:// 1. Teclados
//                Keyboard keyboard = (Keyboard) ItemFactory.getElectrodomestic(ElectroType, key,responseValues);
//                //Addkeyboard
//                break;
//            case 31112://2. Memorias
//                Memory memory = (Memory) ItemFactory.getElectrodomestic(ElectroType, key,responseValues);
//                break;
//            case 31113://3. Ratones
//                Mouse mouse = (Mouse) ItemFactory.getElectrodomestic(ElectroType, key,responseValues);
//                break;
//            case 31114: //4. Impresoras
//                Printer printer = (Printer) ItemFactory.getElectrodomestic(ElectroType, key,responseValues);
//                break;
//            case 31115: //5. Procesadores
//                Procesor procesor = (Procesor) ItemFactory.getElectrodomestic(ElectroType, key,responseValues);
//                break;
//
//            case 1: //Computer
//                Computer computer = (Computer) ItemFactory.getElectrodomestic(ElectroType, key,responseValues);
////                computer.setName(nodesData.get(i++));
////                computer.setDescription(nodesData.get(i++));
////                computer.setSellPrice(Integer.parseInt(nodesData.get(i++)));
////                computer.setQuantity(Integer.parseInt(nodesData.get(i++)));
//                break;
//            case 2: //Fridge
//                Fridge fridge = (Fridge) ItemFactory.getElectrodomestic(ElectroType, key,responseValues);
//
//                //fridge.setName(nodesData.get(i++));
//                // fridge.setDescription(nodesData.get(i++));
//                // fridge.setSellPrice(Integer.parseInt(nodesData.get(i++)));
//                //fridge.setQuantity(Integer.parseInt(nodesData.get(i++)));
//                break;
//            case 3://Phone
//                Phone phone = (Phone) ItemFactory.getElectrodomestic(Integer.parseInt(node.getChildNodes().get(1).getResponseValue()), key);
////                phone.setName(nodesData.get(i++));
////                phone.setDescription(nodesData.get(i++));
////                phone.setSellPrice(Integer.parseInt(nodesData.get(i++)));
////                phone.setQuantity(Integer.parseInt(nodesData.get(i++)));
//                break;
//            case 4://Screen
//                Screen screen = (Screen) ItemFactory.getElectrodomestic(Integer.parseInt(node.getChildNodes().get(1).getResponseValue()), key);
////                screen.setName(nodesData.get(i++));
////                screen.setDescription(nodesData.get(i++));
////                screen.setSellPrice(Integer.parseInt(nodesData.get(i++)));
////                screen.setQuantity(Integer.parseInt(nodesData.get(i++)));
//                break;
//            case 5://Sound
//                Sound sound = (Sound) ItemFactory.getElectrodomestic(Integer.parseInt(node.getChildNodes().get(1).getResponseValue()), key);
////                sound.setName(nodesData.get(i++));
////                sound.setDescription(nodesData.get(i++));
////                sound.setSellPrice(Integer.parseInt(nodesData.get(i++)));
////                sound.setQuantity(Integer.parseInt(nodesData.get(i++)));
//                break;
//        }
                //      
//        switch (ElectroType) {
//
//            case 31111:// 1. Teclados
//                IniKeyboard keyboard = (IniKeyboard) ItemFactory.getElectrodomestic(ElectroType, key,responseValues);
//                //Addkeyboard
//                break;
//            case 31112://2. Memorias
//                Memory memory = (Memory) ItemFactory.getElectrodomestic(ElectroType, key,responseValues);
//                break;
//            case 31113://3. Ratones
//                Mouse mouse = (Mouse) ItemFactory.getElectrodomestic(ElectroType, key,responseValues);
//                break;
//            case 31114: //4. Impresoras
//                Printer printer = (Printer) ItemFactory.getElectrodomestic(ElectroType, key,responseValues);
//                break;
//            case 31115: //5. Procesadores
//                Procesor procesor = (Procesor) ItemFactory.getElectrodomestic(ElectroType, key,responseValues);
//                break;
//
//            case 1: //Computer
//                Computer computer = (Computer) ItemFactory.getElectrodomestic(ElectroType, key,responseValues);
////                computer.setName(nodesData.get(i++));
////                computer.setDescription(nodesData.get(i++));
////                computer.setSellPrice(Integer.parseInt(nodesData.get(i++)));
////                computer.setQuantity(Integer.parseInt(nodesData.get(i++)));
//                break;
//            case 2: //Fridge
//                Fridge fridge = (Fridge) ItemFactory.getElectrodomestic(ElectroType, key,responseValues);
//
//                //fridge.setName(nodesData.get(i++));
//                // fridge.setDescription(nodesData.get(i++));
//                // fridge.setSellPrice(Integer.parseInt(nodesData.get(i++)));
//                //fridge.setQuantity(Integer.parseInt(nodesData.get(i++)));
//                break;
//            case 3://Phone
//                Phone phone = (Phone) ItemFactory.getElectrodomestic(Integer.parseInt(node.getChildNodes().get(1).getResponseValue()), key);
////                phone.setName(nodesData.get(i++));
////                phone.setDescription(nodesData.get(i++));
////                phone.setSellPrice(Integer.parseInt(nodesData.get(i++)));
////                phone.setQuantity(Integer.parseInt(nodesData.get(i++)));
//                break;
//            case 4://Screen
//                Screen screen = (Screen) ItemFactory.getElectrodomestic(Integer.parseInt(node.getChildNodes().get(1).getResponseValue()), key);
////                screen.setName(nodesData.get(i++));
////                screen.setDescription(nodesData.get(i++));
////                screen.setSellPrice(Integer.parseInt(nodesData.get(i++)));
////                screen.setQuantity(Integer.parseInt(nodesData.get(i++)));
//                break;
//            case 5://Sound
//                Sound sound = (Sound) ItemFactory.getElectrodomestic(Integer.parseInt(node.getChildNodes().get(1).getResponseValue()), key);
////                sound.setName(nodesData.get(i++));
////                sound.setDescription(nodesData.get(i++));
////                sound.setSellPrice(Integer.parseInt(nodesData.get(i++)));
////                sound.setQuantity(Integer.parseInt(nodesData.get(i++)));
//                break;
//        }
            }
            return null;
        }

    }

}
