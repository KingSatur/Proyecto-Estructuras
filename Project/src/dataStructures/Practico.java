package dataStructures;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import exceptions.StackEmptyException;
import tda.InterfaceCampiQueue;
import tda.InterfaceCampiStack;

public class Practico {

	private int cantidadConfiguraciones;
	private ArrayList<Integer> cantidadServidores;
	private ArrayList<Integer> cantidadTandas;
	private ArrayList<Integer> tandasIndividuales;
	private int[] tandas;
	private String[] arr;
	private InterfaceCampiStack<Character> pilaGranja;
	private InterfaceCampiQueue<Character> colaEjecucion;
	
	public Practico() {
		cantidadConfiguraciones = 0;
		tandasIndividuales = new ArrayList<Integer>();
		cantidadTandas = new ArrayList<Integer>();
		cantidadServidores = new ArrayList<Integer>();
		pilaGranja = new Abstract<Character>();
		colaEjecucion = new Abstract<Character>();
	}
	
	public ArrayList<Integer> getCantidadServidores() {
		return cantidadServidores;
	}

	public void setCantidadServidores(ArrayList<Integer> cantidadServidores) {
		this.cantidadServidores = cantidadServidores;
	}

	public ArrayList<Integer> getCantidadTandas() {
		return cantidadTandas;
	}

	public void setCantidadTandas(ArrayList<Integer> cantidadTandas) {
		this.cantidadTandas = cantidadTandas;
	}

	public ArrayList<Integer> getTandasIndividuales() {
		return tandasIndividuales;
	}

	public void setTandasIndividuales(ArrayList<Integer> tandasIndividuales) {
		this.tandasIndividuales = tandasIndividuales;
	}

	public InterfaceCampiStack<Character> getPilaGranja() {
		return pilaGranja;
	}

	public void setPilaGranja(InterfaceCampiStack<Character> pilaGranja) {
		this.pilaGranja = pilaGranja;
	}

	public InterfaceCampiQueue<Character> getColaEjecucion() {
		return colaEjecucion;
	}

	public void setColaEjecucion(InterfaceCampiQueue<Character> colaEjecucion) {
		this.colaEjecucion = colaEjecucion;
	}
	
	public void muestraContenido(String archivo) throws IOException, StackEmptyException {
		
		String cadena = "";
		int linea = 1;
		
		FileReader f = new FileReader(archivo);
		BufferedReader b = new BufferedReader(f);
		while((cadena = b.readLine()) != null) {
			if(cantidadConfiguraciones == 0) {
				cantidadConfiguraciones = Integer.parseInt(cadena);
			}
			if(linea > 1) {
				if(linea % 2 == 0) {
					String[] arr = cadena.split(" ");
					cantidadServidores.add(Integer.parseInt(arr[0]));
					cantidadTandas.add(Integer.parseInt(arr[1]));
				}
				else {
					String[] arr = cadena.split(" ");
					for(int i = 0; i < arr.length ; i ++) {
						tandasIndividuales.add(Integer.parseInt(arr[i]));
					}
				}
			}
			if(cantidadServidores.size() == 1 && cantidadTandas.size() == 1 && tandasIndividuales.size() != 0) {
				System.out.println(auxiliar(cantidadServidores.get(0), cantidadTandas.get(0), tandasIndividuales));
				cantidadServidores.clear();
				cantidadTandas.clear();
				tandasIndividuales.clear();
				colaEjecucion = new Abstract<Character>();
				pilaGranja = new Abstract<Character>();
			}
			linea ++;
		}
		b.close();		
	}
	
		
	public int getCantidadConfiguraciones() {
		return cantidadConfiguraciones;
	}

	public String auxiliar(int cantidadServidores, int cantidadTandas, ArrayList<Integer> tandasIndividuales) throws StackEmptyException {
		
		for(int i = 65; i < 65 + cantidadServidores ; i ++) {
			pilaGranja.push(new Character((char) i));
		}
		
		for(int i = 0; i < cantidadTandas; i ++) {
			intercambio(tandasIndividuales.get(i));
		}
		
		devolverToFarm();
				
		return imprimirCola();
		
	}

	public void intercambio(int cantidadDeServidores) throws StackEmptyException {
		
		int m = colaEjecucion.getSize();
		if(m > cantidadDeServidores) {
			int rest = m - cantidadDeServidores;
			for(int i = 0; i < rest; i ++) {
				Character a = colaEjecucion.dequeue();
				pilaGranja.push(a);
			}
		}
		else {
			int rest = cantidadDeServidores - m;
			for(int i = 0; i < rest; i ++) {
				Character b = pilaGranja.pop();
				colaEjecucion.enqueue(b);
			}
		}
	}
	
	public String imprimirCola() {
		
		String a = "";
		
		NodeAbstract<Character> actually = pilaGranja.top();
		
		if(actually.getNextElement() == null) {
			a += actually.getData();
		}
		else {
			boolean salirse = false;
			while(!salirse) {
				a += actually.getData();
				if(actually.getNextElement() == null) {
					salirse = true;
				}
				else {
					actually = actually.getNextElement();					
				}
			}
		}
		
		String cadenaInvertida = "";
		
		for(int i  = a.length() - 1; i >= 0  ; i -- ) {
			cadenaInvertida += a.charAt(i);
		}
		
		return cadenaInvertida;
		
		}
	
	
	public void devolverToFarm() throws StackEmptyException {
		
		boolean salirse = false;
		
		while(!salirse) {
			if(colaEjecucion.front() == null) {
				salirse = true;
			}
			else {
				pilaGranja.push(colaEjecucion.dequeue());				
			}
		}
	}
	
	

	public void setCantidadConfiguraciones(int cantidadConfiguraciones) {
		this.cantidadConfiguraciones = cantidadConfiguraciones;
	}



	public int[] getTandas() {
		return tandas;
	}




	public void setTandas(int[] tandas) {
		this.tandas = tandas;
	}




	public String[] getArr() {
		return arr;
	}




	public void setArr(String[] arr) {
		this.arr = arr;
	}




	public static void main(String[] args) throws StackEmptyException {
		
//		InterfaceCampiStack<Character> pilaGranja = new Abstract<Character>();
//		pilaGranja.push(new Character('A'));
//		pilaGranja.push(new Character('B'));
//		System.out.println(pilaGranja.top().getData());
//		System.out.println(pilaGranja.pop());
//		
//		InterfaceCampiQueue<Character> colaEjecucion = new Abstract<Character>();
//		colaEjecucion.enqueue('A');
//		colaEjecucion.enqueue('B');
//		colaEjecucion.enqueue('C');
//		colaEjecucion.dequeue();
		
		Practico a = new Practico();
		try {
			a.muestraContenido("FilesTest/resultados.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		ArrayList<Integer> m = new ArrayList<Integer>();

	
	InterfaceCampiQueue<String> teAmo = new Abstract<String>();
						
	}

}
