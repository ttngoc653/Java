import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class JCustomTextField extends JTextField {
	private Font originalFont;
    private Color originalForeground;
    /**
     * Grey by default*
     */
    private Color placeholderForeground = new Color(160, 160, 160);
    private boolean textWrittenIn;
    
    private String text_placeholder = "";
    
    /**
     * You can insert all constructors.
     * I inserted only this one.*
     */
    public JCustomTextField(int columns) {
        super(columns);
    }
    
    public JCustomTextField() {
        // super(columns);
    }
 
    @Override
    public void setFont(Font f) {
        super.setFont(f);
        if (!isTextWrittenIn()) {
            originalFont = f;
        }
    }
 
    @Override
    public void setForeground(Color fg) {
        super.setForeground(fg);
        if (!isTextWrittenIn()) {
            originalForeground = fg;
        }
    }
 
    public Color getPlaceholderForeground() {
        return placeholderForeground;
    }
 
    public void setPlaceholderForeground(Color placeholderForeground) {
        this.placeholderForeground = placeholderForeground;
    }
 
    public boolean isTextWrittenIn() {
        return textWrittenIn;
    }
 
    public void setTextWrittenIn(boolean textWrittenIn) {
        this.textWrittenIn = textWrittenIn;
    }
    
    public String getPlaceholder() {
		return text_placeholder;
	}
    
    public void setPlaceholder(final String text) {
    	this.text_placeholder = text;
    	
        this.customizeText(text);
 
        this.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                warn();
            }
 
            @Override
            public void removeUpdate(DocumentEvent e) {
                warn();
            }
 
            @Override
            public void changedUpdate(DocumentEvent e) {
                warn();
            }
 
            public void warn() {
                if (getText().trim().length() != 0) {
                    setFont(originalFont);
                    setForeground(originalForeground);
                    setTextWrittenIn(true);
                }
 
            }
        });
 
        this.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

                if (!isTextWrittenIn()) {
                    setText("");
                }
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				 if (getText().trim().length() == 0) {
	                    customizeText(text);
	                }
			}
        });
        
        this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(!getPlaceholder().equals(getText())) {
					setFont(new Font(getFont().getFamily(),Font.PLAIN,getFont().getSize()));
					setForeground(Color.BLACK);
				}
			}
		});
 
    }
 
    private void customizeText(String text) {
        setText(text);
        /**If you change font, family and size will follow
         * changes, while style will always be italic**/
        setFont(new Font(getFont().getFamily(), Font.ITALIC, getFont().getSize()));
        setForeground(getPlaceholderForeground());
        setTextWrittenIn(false);
    }
}
