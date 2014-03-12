package defpac;


public interface Wood {
	/**
	 * ������� ������ ������� ������.
	 * 
	 * @param name ��� ������� ������
	 * @param start ����� ���������
	 */
	void createWoodman(String name, Point start);

	/**
	 * ���������� ������� ������.
	 * 
	 * @param name ��� ������� ������
	 * @param direction ����������� �����������
	 * @return ��������� �����������
	 */
	Action move(String name, Direction direction);
}