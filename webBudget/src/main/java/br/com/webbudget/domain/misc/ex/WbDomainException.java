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
package br.com.webbudget.domain.misc.ex;

import lombok.Getter;

/**
 * Exception customizada utilizada para encapsular todos os erros da aplicacao
 * a fim de que as mensagens de erro cheguem para o usuario da forma mais clara
 * possivel
 *
 * @author Arthur Gregorio
 *
 * @version 1.0.0
 * @since 2.0.0, 14/07/2015
 */
public class WbDomainException extends RuntimeException {

    @Getter
    private Object[] parameters;

    /**
     * Construtor default
     * 
     * @param message a mensagem de erro
     */
    public WbDomainException(String message) {
        super(message);
    }

    /**
     * Construtor para criar um erro e ainda receber os parametros extras para 
     * serem exibidos como detalhes na view
     *
     * @param message a mensagem de erro
     * @param parameters os parametros do erro
     */
    public WbDomainException(String message, Object... parameters) {
        super(message);
        this.parameters = parameters;
    }

    /**
     * Construtor para criar um erro e ainda receber os parametros extras para 
     * serem exibidos como detalhes na view
     *
     * @param message a mensagem de erro
     * @param throwable o detalhamento do erro
     * @param parameters os parametros do erro
     */
    public WbDomainException(String message, Throwable throwable, Object... parameters) {
        super(message, throwable);
        this.parameters = parameters;
    }
}
