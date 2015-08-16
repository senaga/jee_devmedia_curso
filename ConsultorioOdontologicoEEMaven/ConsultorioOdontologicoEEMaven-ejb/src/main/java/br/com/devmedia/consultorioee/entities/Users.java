package br.com.devmedia.consultorioee.entities;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author senaga
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")})
@Table(name = "users")
public class Users implements Serializable {
    private static final long serialVersionUID = 3L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usu_id", nullable = false)
    private Integer usuId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "usu_name", nullable = false, length = 255)
    private String usuName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "usu_login", nullable = false, length = 255)
    private String usuLogin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "usu_password", nullable = false, length = 32)
    private String usuPassword;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usu_administrator", nullable = false)
    private boolean usuAdministrator;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usu_dentist", nullable = false)
    private boolean usuDentist;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orcDentist")
    private List<Orcamento> orcamentoList = new LinkedList<>();

    public Users() {
    }

    public Users(Integer usuId) {
        this.usuId = usuId;
    }

    public Users(Integer usuId, String usuName, String usuLogin, String usuPassword, boolean usuAdministrator, boolean usuDentist) {
        this.usuId = usuId;
        this.usuName = usuName;
        this.usuLogin = usuLogin;
        this.usuPassword = usuPassword;
        this.usuAdministrator = usuAdministrator;
        this.usuDentist = usuDentist;
    }
    
    public void addOrcamento(Orcamento orcamento) {
        orcamento.setOrcDentist(this);
        orcamentoList.add(orcamento);
    }

    public Integer getUsuId() {
        return usuId;
    }

    public void setUsuId(Integer usuId) {
        this.usuId = usuId;
    }

    public String getUsuName() {
        return usuName;
    }

    public void setUsuName(String usuName) {
        this.usuName = usuName;
    }

    public String getUsuLogin() {
        return usuLogin;
    }

    public void setUsuLogin(String usuLogin) {
        this.usuLogin = usuLogin;
    }

    public String getUsuPassword() {
        return usuPassword;
    }

    public void setUsuPassword(String usuPassword) {
        this.usuPassword = usuPassword;
    }

    public boolean getUsuAdministrator() {
        return usuAdministrator;
    }

    public void setUsuAdministrator(boolean usuAdministrator) {
        this.usuAdministrator = usuAdministrator;
    }

    public boolean getUsuDentist() {
        return usuDentist;
    }

    public void setUsuDentist(boolean usuDentist) {
        this.usuDentist = usuDentist;
    }

    @XmlTransient
    public List<Orcamento> getOrcamentoList() {
        return orcamentoList;
    }

    public void setOrcamentoList(List<Orcamento> orcamentoList) {
        this.orcamentoList = orcamentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuId != null ? usuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        return (this.usuId != null || other.usuId == null) && (this.usuId == null || this.usuId.equals(other.usuId));
    }

    @Override
    public String toString() {
        return "br.com.devmedia.consultorioee.entities.Users[ usuId=" + usuId + " ]";
    }
    
}
