/*
 * Copyright (C) 2015 Arthur Gregorio, AG.Software
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.com.webbudget.domain.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Classe base para indicar que se trata de uma entidade, nela temos os atributos
 * basicos para que a classe possa ser persistente.
 *
 * @author Arthur Gregorio
 *
 * @version 1.0.0
 * @since 1.0.0, 06/10/2013
 */
@MappedSuperclass
@ToString(of = {"id","inclusion"})
@EqualsAndHashCode(of = {"id","inclusion"})
public abstract class PersistentEntity implements IPersistentEntity<Long>, Serializable {

    @Id
    @Getter
    @Column(name = "id", unique = true, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "inclusion", nullable = false)
    private Date inclusion;
    @Getter
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_edition")
    private Date lastEdition;

    /**
     * @return {@inheritDoc}
     */
    @Override
    public boolean isSaved() {
        return !(getId() == null || getId() == 0);
    }

    /**
     * Executa operacoes no prePersist da entidade
     */
    @PrePersist
    protected void prePersist() {
        this.inclusion = new Date();
    }

    /**
     * Executa operacoes no preUpdate da entidade
     */
    @PreUpdate
    protected void preUpdate() {
        this.lastEdition = new Date();
    }
}
