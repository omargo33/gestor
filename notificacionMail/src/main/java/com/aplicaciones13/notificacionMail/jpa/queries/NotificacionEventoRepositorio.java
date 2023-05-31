/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.notificacionMail.jpa.queries;

import com.aplicaciones13.notificacionMail.jpa.model.NotificacionEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author omarv
 */
@Repository
public interface NotificacionEventoRepositorio extends JpaRepository<NotificacionEvento, Long> {
    NotificacionEvento findByIdNotificacionEvento(Long idNotificacionEvento);
}
