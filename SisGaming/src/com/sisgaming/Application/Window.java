/*
 * JFrame responsável pela instâncias de janelas
 */

package com.sisgaming.Application;

import javax.swing.JDesktopPane;

/**
 * SisGaming / Application / Window
 * @author MrX
 */

public class Window {
    
    //#region - Singleton JInternalFrames
    
    private static FrmCadastro cadWindow = null;
    private static FrmUpdate upWindow = null;

    public static void getCadWindow(JDesktopPane desk) {
        if(cadWindow == null || cadWindow.isClosed()) {
            cadWindow = new FrmCadastro();
            cadWindow.setVisible(true);
            desk.add(cadWindow);
            desk.getDesktopManager().maximizeFrame(cadWindow);
        }
    }

    public static void getUpWindow(JDesktopPane desk) {
        if(upWindow == null || upWindow.isClosed()) {
            upWindow = new FrmUpdate();
            upWindow.setVisible(true);
            desk.add(upWindow);
            desk.getDesktopManager().maximizeFrame(upWindow);
        }
    }
    
    //#endregion
    
    public static void getSobreWindow() {
        FrmSobre s = new FrmSobre(null, true);
        s.setVisible(true);
    }
    
}
