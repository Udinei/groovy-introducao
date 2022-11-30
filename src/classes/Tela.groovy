package classes

import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JOptionPane
import java.awt.FlowLayout

class Tela extends JFrame{
    Tela(){
        setTitle("Tela")
        setSize(200,200)
        def botao = new JButton("Clique aqui")
        getContentPane().setLayout(new FlowLayout())
        add(botao)
        botao.addActionListener({JOptionPane.showMessageDialog(null, "Foi via closure")})
    }

}
