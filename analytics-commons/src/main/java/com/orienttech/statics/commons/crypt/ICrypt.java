package com.orienttech.statics.commons.crypt;

/**
 * <p>Title: Orient Project</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Arison</p>
 * @author ������
 * @version $id$
 */

public interface ICrypt {
  public String crypt(String password);
  public boolean matches(String older,String newer);
}
