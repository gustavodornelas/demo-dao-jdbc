package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class UI {

	public static int menu(Scanner sc) {

		System.out.println("Menu");
		System.out.println("1 - Vendedor");
		System.out.println("2 - Departamento");
		System.out.println("0 - Sair");
		System.out.print("Opção: ");
		int menu = sc.nextInt();
		sc.nextLine();

		return menu;

	}

	public static int menuSeller(Scanner sc) {

		System.out.println("----------------------");
		System.out.println("Menu / Vendedor");
		System.out.println("1 - Cadastrar um novo vendedor");
		System.out.println("2 - Atualizar um vendedor");
		System.out.println("3 - Deletar um vendedor");
		System.out.println("4 - Pesquisar um vendedor por ID");
		System.out.println("5 - Pesquisar um vendedor por Departamento");
		System.out.println("6 - Listar todos os vendedores");
		System.out.println("0 - Voltar ao menu anterior");
		System.out.print("Opção: ");
		int menu = sc.nextInt();
		sc.nextLine();
		System.out.println("----------------------");

		return menu;
	}

	public static int menuDepartment(Scanner sc) {

		System.out.println("----------------------");
		System.out.println("Menu / Departamento");
		System.out.println("1 - Cadastrar um novo Departamento");
		System.out.println("2 - Atualizar um Departamento");
		System.out.println("3 - Deletar um Departamento");
		System.out.println("4 - Pesquisar um Departamento por ID");
		System.out.println("5 - Listar todos os Departamentos");
		System.out.println("0 - Voltar ao menu anterior");
		System.out.print("Opção: ");
		int menu = sc.nextInt();
		sc.nextLine();
		System.out.println("----------------------");

		return menu;
	}

	public static Seller insertSeller(Scanner sc) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Nome: ");
		String name = sc.nextLine();

		System.out.print("Email: ");
		String email = sc.nextLine();

		System.out.print("Data de nascimento: ");
		Date birthDate = sdf.parse(sc.next());

		System.out.print("Salário Base: ");
		Double baseSalary = sc.nextDouble();

		System.out.print("Digite o ID do departamento: ");
		Integer idDepartment = sc.nextInt();

		Seller obj = new Seller(null, name, email, birthDate, baseSalary, new Department(idDepartment, null));

		return obj;
	}

	public static Department insertDepartment(Scanner sc) throws ParseException {

		System.out.print("Nome: ");
		String name = sc.nextLine();

		Department obj = new Department(null, name);

		return obj;
	}

	public static Seller updateSeller(Scanner sc) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.print("Digite o ID do vendedor a ser atualizado: ");
		int idSeller = sc.nextInt();
		sc.nextLine();

		Seller obj = sellerDao.findById(idSeller);

		if (obj != null) {

			System.out.print("Nome: ");
			String name = sc.nextLine();

			System.out.print("Email: ");
			String email = sc.nextLine();

			System.out.print("Data de nascimento: ");
			Date birthDate = sdf.parse(sc.next());

			System.out.print("Salário Base: ");
			Double baseSalary = sc.nextDouble();

			System.out.print("Digite o ID do departamento: ");
			Integer idDepartment = sc.nextInt();

			obj = new Seller(idSeller, name, email, birthDate, baseSalary, new Department(idDepartment, null));

			return obj;
		}

		return null;
	}

	public static Department updateDepartment(Scanner sc) throws ParseException {

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.print("Digite o ID do Departamento a ser atualizado: ");
		int idDepartment = sc.nextInt();
		sc.nextLine();

		Department obj = departmentDao.findById(idDepartment);

		if (obj != null) {

			System.out.print("Nome: ");
			String name = sc.nextLine();

			obj = new Department(idDepartment, name);

			return obj;
		}

		return null;
	}

	public static int getIdSeller(Scanner sc) {

		System.out.print("Digite o ID do vendedor: ");
		int id = sc.nextInt();

		return id;
	}

	public static int getIdDepartment(Scanner sc) {

		System.out.print("Digite o ID do departamento: ");
		int id = sc.nextInt();

		return id;
	}

	public static Department getDepartment(Scanner sc) {

		System.out.print("Digite o ID do departamento: ");
		int id = sc.nextInt();

		return new Department(id, null);
	}
}
