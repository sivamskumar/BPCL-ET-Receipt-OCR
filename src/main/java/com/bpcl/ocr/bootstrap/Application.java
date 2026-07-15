package com.bpcl.ocr.bootstrap;

/**
 * Entry point for the BPCL Electronic Totalizer Receipt OCR application.
 *
 * <p>
 * This class is responsible for bootstrapping the application.
 * In future milestones it will initialize configuration, logging,
 * OCR engine, services and the desktop UI.
 * </p>
 *
 * @author Sivakumar Mani
 * @version 0.1.0
 */
public final class Application {

    /**
     * Private constructor.
     */
    private Application() {
    }

    /**
     * Application entry point.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {

        System.out.println("==============================================");
        System.out.println(" BPCL Electronic Totalizer Receipt OCR");
        System.out.println(" Version : 0.1.0-SNAPSHOT");
        System.out.println("==============================================");
        System.out.println();
        System.out.println("Application bootstrap completed successfully.");

    }

}