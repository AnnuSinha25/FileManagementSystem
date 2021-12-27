/**
 * 
 */
package javaprogram.java.filemanager;

import java.io.File;

/**
 * @author Annu Sinha
 *
 */
public class FileFilter implements IFileFilter {

	String initials;
	/**
	 * 
	 */
	public FileFilter(String initials)
    {
        this.initials = initials;
    }

	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		return name.startsWith(initials);
	}

}
