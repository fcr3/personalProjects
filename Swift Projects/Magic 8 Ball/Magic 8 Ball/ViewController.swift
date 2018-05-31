//
//  ViewController.swift
//  Magic 8 Ball
//
//  Created by Flaviano Reyes on 5/30/18.
//  Copyright © 2018 Christian Reyes. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var view8Ball: UIImageView!
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        randBall()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    @IBAction func askButton(_ sender: UIButton) {
        randBall()
    }
    
    override func motionEnded(_ motion: UIEventSubtype, with event: UIEvent?) {
        randBall()
    }
    
    func randBall() {
        let randNum = Int(arc4random_uniform(5)) + 1
        view8Ball.image = UIImage(named: "ball\(randNum)")
    }
    
}

