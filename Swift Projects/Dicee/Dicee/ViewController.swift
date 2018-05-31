//
//  ViewController.swift
//  Dicee
//
//  Created by Flaviano Reyes on 5/29/18.
//  Copyright © 2018 Christian Reyes. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    var randDiceIndex1: Int = 0
    var randDiceIndex2: Int = 0
    
    @IBOutlet weak var diceImageView1: UIImageView!
    @IBOutlet weak var diceImageView2: UIImageView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        rollDie()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    @IBAction func rollButtonPressed(_ sender: UIButton) {
        rollDie()
    }
    
    func rollDie() {
        randDiceIndex1 = Int(arc4random_uniform(6)) + 1
        randDiceIndex2 = Int(arc4random_uniform(6)) + 1
        
        diceImageView1.image = UIImage(named: "dice\(randDiceIndex1)")
        diceImageView2.image = UIImage(named: "dice\(randDiceIndex2)")
    }
    
    override func motionEnded(_ motion: UIEventSubtype, with event: UIEvent?) {
        rollDie()
    }
}

