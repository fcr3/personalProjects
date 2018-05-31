//
//  ViewController.swift
//  Quizzler
//
//  Created by Angela Yu on 25/08/2015.
//  Copyright (c) 2015 London App Brewery. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    //Place your instance variables here
    
    
    @IBOutlet weak var questionLabel: UILabel!
    @IBOutlet weak var scoreLabel: UILabel!
    @IBOutlet var progressBar: UIView!
    @IBOutlet weak var progressLabel: UILabel!
    
    var qBank = Bank()
    var score = 0
    var questionNum = 1
    var width = Int(UIScreen.main.bounds.width) * 1 / 13
    var usedQuestions = [Int]()
    var qIndex = 0
    
    override func viewDidLoad() {
        super.viewDidLoad()
        progressBar.frame.size.width = CGFloat(width)
        nextQuestion()
    }


    @IBAction func answerPressed(_ sender: AnyObject) {
        if sender.tag == 1 {
            checkAnswer(true)
        } else {
            checkAnswer(false)
        }
    }
    
    
    func updateUI(_ correct : Bool) {
        if correct {
            ProgressHUD.showSuccess("Correct")
            score = score + 100
        } else {
            ProgressHUD.showError("Incorrect")
            score = score - 50
        }
        usedQuestions.append(qIndex)
        questionNum = questionNum + 1
        width = Int(UIScreen.main.bounds.width) * questionNum / 13
        nextQuestion()
    }
    

    func nextQuestion() {
        scoreLabel.text = "Score: \(score)"
        if (questionNum < 14) {
            progressLabel.text = "\(questionNum)/13"
        } else {
            progressLabel.text = "13/13"
        }
        if (questionNum > 13) {
            
            let alert = UIAlertController(title: "Congrats! Your Score: \(score)", message: "Would you like to restart?", preferredStyle: .alert)
            
            let restartAction  = UIAlertAction(title: "Restart", style: .default) { (UIAlertAction) in self.startOver()}
            
            alert.addAction(restartAction)
            
            present(alert, animated: true, completion: nil)
            return
        }
        progressBar.frame.size.width = CGFloat(width)
        qIndex = Int(arc4random_uniform(UInt32(qBank.list.count)))
        while (usedQuestions.contains(qIndex)) {
            qIndex = Int(arc4random_uniform(UInt32(qBank.list.count)))
        }
        let queuedQ : Question = qBank.list[qIndex]
        questionLabel.text = queuedQ.questionText
    }
    
    
    func checkAnswer(_ choice : Bool) {
        let queuedQ : Question = qBank.list[qIndex]
        if choice == queuedQ.answer {
            updateUI(true)
        } else {
            updateUI(false)
        }
    }
    
    
    func startOver() {
        score = 0
        questionNum = 1
        width = Int(UIScreen.main.bounds.width) * 1 / 13
        usedQuestions = [Int]()
        nextQuestion()
    }
    
}
