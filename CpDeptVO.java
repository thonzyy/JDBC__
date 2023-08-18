package day0818;

public class CpDeptVO {
private String dname;
private String loc;
private int deptno;
public CpDeptVO () {
	
}

public CpDeptVO(String dname, String loc, int deptno) {
	super();
	this.dname = dname;
	this.loc = loc;
	this.deptno = deptno;
}

/**
 * @return the dname
 */
public String getDname() {
	return dname;
}
/**
 * @param dname the dname to set
 */
public void setDname(String dname) {
	this.dname = dname;
}
/**
 * @return the loc
 */
public String getLoc() {
	return loc;
}
/**
 * @param loc the loc to set
 */
public void setLoc(String loc) {
	this.loc = loc;
}
/**
 * @return the deptno
 */
public int getDeptno() {
	return deptno;
}
/**
 * @param deptno the deptno to set
 */
public void setDeptno(int deptno) {
	this.deptno = deptno;
}

}
