package com.web.automotriz.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import org.springframework.stereotype.Service;

import com.web.automotriz.dto.ConsultaMercancia;
import com.web.automotriz.model.Mercancia;
import com.web.automotriz.repository.MercanciaRepository;

@Service
public class MercanciaService extends MercanciaRepository {

    public Map<String, Object> insertMercancia(Mercancia mercancia) {

        Map<String, Object> response = new HashMap<String, Object>();
        try {

            if (validateDate(mercancia)) {

                if (selectNombreMercanciaRepository(mercancia)) {
                    response.put("mensaje", "Mercancia existente");
                } else if (insertMercanciaRepository(mercancia) == 1) {
                    response.put("mensaje", "Mercancia registrada");
                }

            } else {
                response.put("mensaje", "La fecha debe ser igual o menor a la actual");
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("ERROR EN PROCESOS BACKEND::" + e.getMessage());
            response.put("mensaje", "Error en el backend");
        }

        return response;

    }

    public Map<String, Object> updateMercancia(Mercancia mercancia) {

        Map<String, Object> response = new HashMap<String, Object>();
        try {

            if (updateMercanciaRepository(mercancia) == 1) {
                response.put("message", "Mercancia actualizada");
            } else {
                response.put("message", "Mercancia no actualizada");
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("ERROR EN PROCESOS BACKEND::" + e.getMessage());
            response.put("mensaje", "Error en el backend");
        }

        return response;

    }

    public Map<String, Object> deleteMercancia(Mercancia mercancia) {

        Map<String, Object> response = new HashMap<String, Object>();
        try {

            if (deleteMercanciaRepository(mercancia) == 1) {
                response.put("message", "Mercancia eliminada");
            } else {
                response.put("message", "Esta mercancia no se puede eliminar porque no coincide con el usuario que la registro");
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("ERROR EN PROCESOS BACKEND::" + e.getMessage());
            response.put("mensaje", "Error en el backend");
        }

        return response;

    }

    public Map<String, Object> selectRegistroMercancia(ConsultaMercancia consultaMercancia) {

        return selectRegistroMercanciaRepository(consultaMercancia);

    }

    private boolean validateDate(Mercancia mercancia) {

        try {

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            formatter.setTimeZone(TimeZone.getTimeZone("UTC"));

            Date fechaServer = new Date(Calendar.getInstance().getTimeInMillis());
            String fechaTexto = formatter.format(fechaServer);


            String fechaTextoJson = formatter.format(mercancia.getFecha_ingreso());

            Date date1 = formatter.parse(fechaTexto);
            Date date2 = formatter.parse(fechaTextoJson);

            if (!date2.after(date1)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("ERROR EN FECHAS::" + e.getMessage());
            return false;
        }

    }
}
