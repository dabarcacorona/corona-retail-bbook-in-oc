package com.jadm.model;

public class JsonDet {
	
	private String ean13;
	private String style_prepack;
	private String desc_producto;
	private String style_corona;
	private String estilo;
	private String color;
	private String talla;
	private String copa;
	private String orden_compra;
	private String proforma_invoice;
	private String precio_blanco;
	private String precio_vigente;
	private String temporada;
	
	public JsonDet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JsonDet(String ean13, String style_prepack, String desc_producto, String style_corona, String estilo,
			String color, String talla, String copa, String orden_compra, String proforma_invoice, String precio_blanco,
			String precio_vigente, String temporada) {
		super();
		this.ean13 = ean13;
		this.style_prepack = style_prepack;
		this.desc_producto = desc_producto;
		this.style_corona = style_corona;
		this.estilo = estilo;
		this.color = color;
		this.talla = talla;
		this.copa = copa;
		this.orden_compra = orden_compra;
		this.proforma_invoice = proforma_invoice;
		this.precio_blanco = precio_blanco;
		this.precio_vigente = precio_vigente;
		this.temporada = temporada;
	}

	@Override
	public String toString() {
		return "JsonDet [ean13=" + ean13 + ", style_prepack=" + style_prepack + ", desc_producto=" + desc_producto
				+ ", style_corona=" + style_corona + ", estilo=" + estilo + ", color=" + color + ", talla=" + talla
				+ ", copa=" + copa + ", orden_compra=" + orden_compra + ", proforma_invoice=" + proforma_invoice
				+ ", precio_blanco=" + precio_blanco + ", precio_vigente=" + precio_vigente + ", temporada=" + temporada
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	public String getEan13() {
		return ean13;
	}

	public void setEan13(String ean13) {
		this.ean13 = ean13;
	}

	public String getStyle_prepack() {
		return style_prepack;
	}

	public void setStyle_prepack(String style_prepack) {
		this.style_prepack = style_prepack;
	}

	public String getDesc_producto() {
		return desc_producto;
	}

	public void setDesc_producto(String desc_producto) {
		this.desc_producto = desc_producto;
	}

	public String getStyle_corona() {
		return style_corona;
	}

	public void setStyle_corona(String style_corona) {
		this.style_corona = style_corona;
	}

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public String getCopa() {
		return copa;
	}

	public void setCopa(String copa) {
		this.copa = copa;
	}

	public String getOrden_compra() {
		return orden_compra;
	}

	public void setOrden_compra(String orden_compra) {
		this.orden_compra = orden_compra;
	}

	public String getProforma_invoice() {
		return proforma_invoice;
	}

	public void setProforma_invoice(String proforma_invoice) {
		this.proforma_invoice = proforma_invoice;
	}

	public String getPrecio_blanco() {
		return precio_blanco;
	}

	public void setPrecio_blanco(String precio_blanco) {
		this.precio_blanco = precio_blanco;
	}

	public String getPrecio_vigente() {
		return precio_vigente;
	}

	public void setPrecio_vigente(String precio_vigente) {
		this.precio_vigente = precio_vigente;
	}

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}
	
	

	
	
	
}
