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
    let sectionView = MainMenuTableViewSectionHeader()
    
    // MARK: - Lifecycles
    override func viewDidLoad() {
        super.viewDidLoad()
        tableView.dataSource = dataSource
        sectionView.update(category: "category", title: "title")
    }
}

extension MainMenuViewController {
    override func tableView(_ tableView: UITableView, viewForHeaderInSection section: Int) -> UIView? {
        return sectionView
    }
    
    override func tableView(_ tableView: UITableView, heightForHeaderInSection section: Int) -> CGFloat {
        return MainMenuTableViewSectionHeader.height
    }
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        
    }
}
