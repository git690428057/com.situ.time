package login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��֤�����ɳ���
 * 
 */
public class CheckImgServlet extends HttpServlet {
	/** 
     *  
     */
	private static final long serialVersionUID = 2376992603034716655L;
	private final Font mFont = new Font("Arial Black", Font.PLAIN, 15); // ��������
	private final int lineWidth = 2; // �����ߵĳ���=1.414*lineWidth
	private final int width = 88; // ����ͼ�δ�С
	private final int height = 25; // ����ͼ�δ�С
	private final int count = 200;

	/**
	 * ������
	 * 
	 * @param fc
	 *            ������
	 * @param bc
	 *            ������
	 * 
	 * @return ������
	 */
	private Color getRandColor(int fc, int bc) { // ȡ�ø�����Χ�����ɫ

		final Random random = new Random();

		if (fc > 255) {
			fc = 255;
		}

		if (bc > 255) {
			bc = 255;
		}

		final int r = fc + random.nextInt(bc - fc);
		final int g = fc + random.nextInt(bc - fc);
		final int b = fc + random.nextInt(bc - fc);

		return new Color(r, g, b);
	}

	// ����post
	@Override
	public void doPost(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {

		doGet(request, response);
	}

	/**
	 * ������
	 * 
	 * @param request
	 *            ������
	 * @param response
	 *            ������
	 * 
	 * @throws ServletException
	 *             ������
	 * @throws IOException
	 *             ������
	 */
	@Override
	public void doGet(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		response.reset();
		// ����ҳ�治����
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/gif");
		// ���ڴ��д���ͼ��
		final BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);

		// ��ȡͼ��������
		final Graphics2D g = (Graphics2D) image.getGraphics();

		// ���������
		final Random random = new Random();

		// �趨����ɫ
		g.setColor(getRandColor(200, 250)); // ---1

		g.fillRect(0, 0, width, height);

		// �趨����
		g.setFont(mFont);

		// ���߿�
		g.setColor(getRandColor(0, 20)); // ---2

		// ����
		g.drawRect(0, 0, width - 1, height - 1);

		// ������������ߣ�ʹͼ���е���֤�벻�ױ���������̽�⵽
		for (int i = 0; i < count; i++) {

			g.setColor(getRandColor(150, 200)); // ---3

			final int x = random.nextInt(width - lineWidth - 1) + 1; // ��֤���ڱ߿�֮��
			final int y = random.nextInt(height - lineWidth - 1) + 1;
			final int xl = random.nextInt(lineWidth);
			final int yl = random.nextInt(lineWidth);
			g.drawLine(x, y, x + xl, y + yl);
		}

		// ȡ�����������֤��(4λ����)
		String sRand = "";

		for (int i = 0; i < 4; i++) {

			final String rand = String.valueOf(random.nextInt(10));
			sRand += rand;

			// ����֤����ʾ��ͼ����,���ú�����������ɫ��ͬ����������Ϊ����̫�ӽ�������ֻ��ֱ������
			g.setColor(new Color(20 + random.nextInt(130), 20 + random
					.nextInt(130), 20 + random.nextInt(130))); // --4--50-100
			// ��һ��������Ҫ����ȥ���ַ��� ����������������� (0,0) x���y��
			g.drawString(rand, (13 * i) + 10, 20);

		}

		// ����֤�����SESSION
		request.getSession().setAttribute("checkCodeSession", sRand);

		// ͼ����Ч
		// �������������ٳ�����ָ����ͼ�ν�����Դ�������ʹ����graphics���windowsһЩͼ����Դ���������йرյĻ������ں��ڶ���ʹ�þͻ�����ڴ����������ģ����³�������
		g.dispose();
		final java.io.OutputStream os = response.getOutputStream();
		// ���ͼ��ҳ��
		ImageIO.write(image, "PNG", os);
		os.flush();
		os.close();
	}
}
