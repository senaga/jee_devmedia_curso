package br.com.devmedia.consultorioee.entities;

/**
 *
 * @author senaga
 */
public enum PaymentType {
    
    DINHEIRO("DINHEIRO"),
    CREDITO("CREDITO"),
    DEBITO("DEBITO");

    private final String description;

    PaymentType(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }    
}
