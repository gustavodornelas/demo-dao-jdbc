package application;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);

		int menu;
		boolean sair = false;

		do {

			menu = UI.menu(sc);

			if (menu == 1) {

				do {

					SellerDao sellerDao = DaoFactory.createSellerDao();

					menu = UI.menuSeller(sc);

					switch (menu) {

					case 1: // Insert Seller
						Seller newSeller = UI.insertSeller(sc);

						sellerDao.insert(newSeller);
						System.out.println("Inserted! new id = " + newSeller.getId());

						break;
					case 2: // Update Seller

						newSeller = UI.updateSeller(sc);
						sellerDao.update(newSeller);

						break;
					case 3: // Delete Seller

						int idSeller = UI.getIdSeller(sc);
						sellerDao.deleteById(idSeller);

						break;
					case 4: // Get Seller by ID
						idSeller = UI.getIdSeller(sc);
						Seller seller = sellerDao.findById(idSeller);
						System.out.println(seller);

						break;
					case 5: // Get Sellers by Department
						Department department = UI.getDepartment(sc);

						List<Seller> list = sellerDao.findByDepartment(department);

						for (Seller s : list) {
							System.out.println(s);
						}

						break;
					case 6: // Get all Sellers

						System.out.println("Listando todos os Vendedores");
						list = sellerDao.findAll();

						for (Seller s : list) {
							System.out.println(s);
						}

						break;
					case 0: // Return
						System.out.println("Voltando ao menu anterior");
						break;

					default:
						System.out.println("Opção Invalida");
						break;

					}

				} while (menu != 0);

			} else if (menu == 2) {

				do {

					DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

					menu = UI.menuDepartment(sc);

					switch (menu) {

					case 1: // Insert Department
						Department newDepartment = UI.insertDepartment(sc);

						departmentDao.insert(newDepartment);
						System.out.println("Inserted! new id = " + newDepartment.getId());

						break;
					case 2: // Update Department

						newDepartment = UI.updateDepartment(sc);
						departmentDao.update(newDepartment);

						break;
					case 3: // Delete Department

						int idDepartment = UI.getIdDepartment(sc);
						departmentDao.deleteById(idDepartment);

						break;
					case 4: // Get Department by ID
						idDepartment = UI.getIdDepartment(sc);
						Department department = departmentDao.findById(idDepartment);
						System.out.println(department);

						break;
					case 5: // Get all Departments

						System.out.println("Listando todos os Vendedores");
						List<Department> list = departmentDao.findAll();

						for (Department d : list) {
							System.out.println(d);
						}

						break;
					case 0: // Return
						System.out.println("Voltando ao menu anterior");
						break;

					default:
						System.out.println("Opção Invalida");
						break;

					}

				} while (menu != 0);

			} else if (menu == 0) {
				System.out.println("Encerrando Sistema!");
				sair = true;
			}

			System.out.println("----------------------");
		} while (!sair);

		sc.close();
	}
}
