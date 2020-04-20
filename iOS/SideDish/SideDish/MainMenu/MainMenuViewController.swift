//
//  MainMenuViewController.swift
//  SideDish
//
//  Created by Cloud on 2020/04/20.
//  Copyright © 2020 Cloud. All rights reserved.
//

import UIKit

class MainMenuViewController: UITableViewController {
    
    // MARK: - Properties
    private let dataSource = MainMenuTableViewDataSource()
    
    // MARK: - Lifecycles
    override func viewDidLoad() {
        super.viewDidLoad()
        tableView.dataSource = dataSource
    }
}

