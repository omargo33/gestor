/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.notificacionMail.jpa.queries;

import com.aplicaciones13.notificacionMail.jpa.model.NotificacionParametro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author omarv
 */
@Repository
public interface NotificacionParametroRepositorio extends JpaRepository<NotificacionParametro, Long> {
    List<NotificacionParametro> findByIdNotificacionAndTipo(Long idNotificacion, String tipo);
}
