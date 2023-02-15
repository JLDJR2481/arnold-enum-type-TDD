package edu.craptocraft.arnoldenumtype;

import java.util.EnumSet;

public enum Planeta {

    /*
     * Peso en superficie = tu_masa * Gravedad_en_superficie
     * 
     * 
     * Gravedad_en_superficie = Gravedad * masa_del_planeta /
     * radio_del_planeta_al_cuadrado
     * 
     * Gravedad = 6.67300e-11
     * 
     * tu_masa = tu_peso_en_la_Tierra / gravedad_en_superficie_Tierra
     */

    // Planeta(masa, radio)
    MERCURY(3.303e+23, 2.4397e+6),
    VENUS(4.869e+24, 6.0518e+6),
    EARTH(5.976e+24, 6.37814e+6),
    MARS(6.421e+23, 3.3972e+6),
    JUPITER(1.9e+27, 7.1492e+7),
    SATURN(5.688e+26, 6.0268e+7),
    URANUS(8.686e+25, 2.5559e+7),
    NEPTUNE(1.024e+26, 2.4746e+7);

    public static final double gravedad = 6.67300e-11;

    private double masa = 0f;
    private double radio = 0f;

    private Planeta(double masa, double radio) {
        this.masa = masa;
        this.radio = radio;
    }

    // Conseguir la masa del planeta

    public double getMasa() {
        return this.masa;
    }

    // Conseguir el radio del planeta
    public double getRadio() {
        return this.radio;
    }

    // Calcular el peso en superficie
    public double pesoSuperficie(double peso) {
        return masaTerrestre(peso) * this.gravedadSuperficie();
    }

    // Calcular masa terrestre
    public double masaTerrestre(double peso) {
        return peso / this.gravedadSuperficie(EARTH);
    }

    // Calcular gravedad superficial
    public double gravedadSuperficie() {
        return gravedad * this.masa / Math.pow(this.radio, 2);
    }

    // Calcular gravedad superficial del planeta
    public double gravedadSuperficie(Planeta planeta) {
        return gravedad * planeta.getMasa() / Math.pow(planeta.getRadio(), 2);
    }

    // Conseguir los planetas terrestres (MERCURY, VENUS, EARTH, MARS)

    public static EnumSet<Planeta> getPlanetasTerrestres() {
        return EnumSet.range(MERCURY, MARS);

    }

    public static EnumSet<Planeta> getGigantesGaseosos() {
        return EnumSet.complementOf(getPlanetasTerrestres());
    }
}
