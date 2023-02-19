package edu.craptocraft.arnoldenumtype;

public enum Planeta {

    MERCURY(3.303e+23, 2.4397e6),
    VENUS(4.869e+24, 6.0518e6),
    EARTH(5.976e+24, 6.37814e6),
    MARS(6.421e+23, 3.3972e6),
    JUPITER(1.9e+27, 7.1492e7),
    SATURN(5.688e+26, 6.0268e7),
    URANUS(8.686e+25, 2.5559e7),
    NEPTUNE(1.024e+26, 2.4746e7);

    private double masa = 0d;
    private double radio = 0d;

    public static final double gravity = 6.67300E-11;

    private Planeta(double masa, double radio) {
        this.masa = masa;
        this.radio = radio;
    }

    // Conseguir masa del planeta
    public double getMasa() {
        return this.masa;
    }

    // Conseguir radio del planeta
    public double getRadio() {
        return this.radio;
    }

    // Calcular la masa propia en la Tierra
    /*
     * Fórmula
     * peso en la tierra / gravedad superficial de la tierra
     */

    private double calcularMasaPropia(double peso) {
        return peso / gravedadSuperficie(EARTH);
    }

    // Calcular gravedad superficial de Planetas. Utilidad: Calcular masa propia
    // usando la Tierra
    /*
     * Fórmula
     * Gravedad * masa del planeta / radio del planeta ^ 2
     */

    public double gravedadSuperficie(Planeta planeta) {
        return (gravity * planeta.getMasa()) / Math.pow(planeta.getRadio(), 2);
    }

    // Calcular gravedad superficie (No especificando planeta)

    private double gravedadSuperficie() {
        return (gravity * this.masa) / Math.pow(this.radio, 2);
    }

    // Calcular el peso en la superficie
    /*
     * Fórmula
     * masa propia * gravedad superficie
     */

    public double pesoSuperficie(double peso) {
        return (calcularMasaPropia(peso) * gravedadSuperficie());
    }

}
