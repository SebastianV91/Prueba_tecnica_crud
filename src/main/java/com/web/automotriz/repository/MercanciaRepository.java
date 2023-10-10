package com.web.automotriz.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.web.automotriz.exceptions.EtBadRequestException;
import com.web.automotriz.exceptions.EtResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.web.automotriz.dto.ConsultaMercancia;
import com.web.automotriz.model.Mercancia;
import com.web.automotriz.mapper.ProductoMercancia;

@Component
public class MercanciaRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insertMercanciaRepository(Mercancia mercancia) throws EtBadRequestException {
		try {
			String sql = "INSERT INTO INVENTARIOAUTOMOTRIZ.MERCANCIA "
					+ " (NOMBRE_PRODUCTO, CANTIDAD, FECHA_INGRESO, USUARIOID) "
					+ "VALUES (?, ?, ?, ?) ";

			int rows = jdbcTemplate.update(sql, mercancia.getNombre_producto(), mercancia.getCantidad(), mercancia.getFecha_ingreso(), mercancia.getUsuarioid());

			return rows;
		} catch (Exception e) {
			throw new EtBadRequestException("No funciona insercion en repositorio de mercancia");
		}

	}

	public int updateMercanciaRepository(Mercancia mercancia) throws EtBadRequestException {
		try {
			String sql = " UPDATE INVENTARIOAUTOMOTRIZ.MERCANCIA "
					+ " SET NOMBRE_PRODUCTO=?, CANTIDAD=?, USUARIOIDMODIFICACION=?, FECHA_MODIFICACION=CURRENT_DATE   "
					+ "WHERE IDMERCANCIA = ? ";

			int rows = jdbcTemplate.update(sql, mercancia.getNombre_producto(), mercancia.getCantidad(), mercancia.getUsuarioidmodificacion(), mercancia.getIdmercancia());

			return rows;
		} catch (Exception e) {
			throw new EtBadRequestException("No funciona actualizacion en repositorio de mercancia");
		}

	}

	public int deleteMercanciaRepository(Mercancia mercancia) {

		String sql = " DELETE FROM INVENTARIOAUTOMOTRIZ.MERCANCIA "
				+ "WHERE IDMERCANCIA = ? AND USUARIOID = ? ";

		int rows = jdbcTemplate.update(sql, mercancia.getIdmercancia(), mercancia.getUsuarioid());

		return rows;

	}

	public boolean selectNombreMercanciaRepository(Mercancia mercancia) {

		String sql = "SELECT  "
				+ " NOMBRE_PRODUCTO, CANTIDAD, FECHA_INGRESO "
				+ " FROM INVENTARIOAUTOMOTRIZ.MERCANCIA  "
				+ "WHERE NOMBRE_PRODUCTO = ? ";

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, mercancia.getNombre_producto());

		if (rows != null) {

			if (rows.isEmpty()) {
				return false;
			} else {
				return true;
			}

		} else {
			return true;
		}

	}

	public Map<String, Object> selectRegistroMercanciaRepository(ConsultaMercancia consultaMercancia) {

		Map<String, Object> respuesta = new HashMap<>();
		List<ProductoMercancia> listProductoMercancia = new ArrayList<>();

		String sql = "SELECT  "
				+ " A.NOMBRE_PRODUCTO, A.CANTIDAD, A.FECHA_INGRESO, B.NOMBRE "
				+ " FROM INVENTARIOAUTOMOTRIZ.MERCANCIA A INNER JOIN INVENTARIOAUTOMOTRIZ.USUARIO B ON B.IDUSUARIO = A.USUARIOID "
				+ " WHERE A.FECHA_INGRESO IS NULL OR A.FECHA_INGRESO = TO_DATE(?, 'YYYY-MM-DD') OR B.NOMBRE = ? OR B.NOMBRE IS NULL ";

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, consultaMercancia.getFecha_ingreso(), consultaMercancia.getNombre());

		if (rows != null) {
			for (Map<String, Object> row : rows) {
				ProductoMercancia productoMercancia = new ProductoMercancia();
				productoMercancia.setNombre_producto((String) row.get("NOMBRE_PRODUCTO"));
				productoMercancia.setCantidad((Integer) row.get("CANTIDAD"));
				productoMercancia.setFecha_ingreso((Date) row.get("FECHA_INGRESO"));
				productoMercancia.setNombre((String) row.get("NOMBRE"));
				listProductoMercancia.add(productoMercancia);
			}

			if (rows.isEmpty()) {
				respuesta.put("message", "Este registro no existe");
			} else {
				respuesta.put("productoMercancia", listProductoMercancia);
			}

		}

		return respuesta;

	}

}
