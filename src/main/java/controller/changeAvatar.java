package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;

import database.CustomerDAO;
import model.Customer;

/**
 * Servlet implementation class changeAvatar
 */
@WebServlet("/change-avatar")
public class changeAvatar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public changeAvatar() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object o = session.getAttribute("customer");
		Customer c = null;
		if (o != null) {
			c = (Customer) o;
			if (c != null) {
				String folder = getServletContext().getRealPath("avatar");
				System.out.println("folder: " + folder);
				File file;
				int maxFileSize = 5000 * 1024;// 5MB
				int maxMemsize = 5000 * 1024;

				String contentType = request.getContentType();

				if (contentType.indexOf(contentType) >= 0) {
					try {
						DiskFileItemFactory factory = new DiskFileItemFactory();

						// Set max size for a file
						factory.setSizeThreshold(maxMemsize);
						
						ServletFileUpload upload = new ServletFileUpload(factory);
						upload.setFileItemFactory((FileItemFactory) factory);

						upload.setSizeMax(maxFileSize);
						// Create file
						
						List<FileItem> files = upload.parseRequest(request);
						
						for (FileItem fileItem : files) {
						
							if (!fileItem.isFormField()) {

								String fileName = System.currentTimeMillis() + fileItem.getName();

								String path = folder + "\\" + fileName;
								file = new File(path);
								System.out.println("this");
								fileItem.write(file);
								c.setImgPath(fileName);
								CustomerDAO cDao = new CustomerDAO();
								cDao.updateImg(c);
								c = cDao.selectById(c);
							} else {
								// When upload file, can not get data like common
								String name = fileItem.getFieldName();
								String value = fileItem.getString();
								System.out.println(name + " : " + value);
							}
						}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
