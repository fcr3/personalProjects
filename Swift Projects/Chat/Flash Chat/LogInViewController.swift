//
//  LogInViewController.swift
//  Flash Chat
//
//  This is the view controller where users login


import UIKit
import Firebase
import SVProgressHUD

class LogInViewController: UIViewController {

    //Textfields pre-linked with IBOutlets
    @IBOutlet var emailTextfield: UITextField!
    @IBOutlet var passwordTextfield: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }

   
    @IBAction func logInPressed(_ sender: AnyObject) {
        //TODO: Log in the user
        
        SVProgressHUD.show()
        
        if let email = emailTextfield.text, let pass = passwordTextfield.text {
            Auth.auth().signIn(withEmail: email, password: pass) { (user, error) in
                if let err = error {
                    SVProgressHUD.showError(withStatus: "Could Not Find User")
                    print(err)
                } else {
                    SVProgressHUD.dismiss()
                    self.performSegue(withIdentifier: "goToChat", sender: self)
                }
            }
        }
    }
}  
