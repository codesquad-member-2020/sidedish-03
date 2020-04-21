//
//  MainMenuTableViewSectionHeader.swift
//  SideDish
//
//  Created by Cloud on 2020/04/20.
//  Copyright © 2020 Cloud. All rights reserved.
//

import UIKit
import SnapKit

extension UIFont {
    static var categorySize: CGFloat = 12
    static var boldTitleSize: CGFloat = 16
}

extension CALayer {
    static var categoryWidth: CGFloat = 0.5
}

class MainMenuTableViewSectionHeader: UITableViewHeaderFooterView {
    
    // MARK: - IBOutlets
    private var colorView: UIView = {
        let view = UIView()
        view.backgroundColor = .white
        return view
    }()
    private var categoryLabel: UILabel = {
        let label = UILabel()
        label.textAlignment = .center
        label.textColor = .systemGray
        label.font = UIFont.systemFont(ofSize: UIFont.categorySize)
        label.layer.borderWidth = CALayer.categoryWidth
        label.layer.borderColor = UIColor.systemGray.cgColor
        return label
    }()
    private var titleLabel: UILabel = {
        let label = UILabel()
        label.textAlignment = .center
        label.font = UIFont.boldSystemFont(ofSize: UIFont.boldTitleSize)
        return label
    }()
    
    // MARK: - Properties
    static var height: CGFloat = 50
    
    // MARK: - Lifecyles
    override init(reuseIdentifier: String?) {
        super.init(reuseIdentifier: reuseIdentifier)
        configure()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        configure()
    }
    
    // MARK: - Methods
    private func configure() {
        configureBackgroundView()
        configureCategoryLabel()
        configureTitleLabel()
    }
    
    private func configureBackgroundView() {
        addSubview(colorView)
        colorView.snp.makeConstraints { make in
            make.edges.equalToSuperview()
        }
    }
    
    private func configureCategoryLabel() {
        colorView.addSubview(categoryLabel)
        categoryLabel.snp.makeConstraints { make in
            make.centerX.equalToSuperview()
            make.top.equalToSuperview().inset(4)
            make.leading.equalToSuperview().inset(160)
        }
    }
    
    private func configureTitleLabel() {
        colorView.addSubview(titleLabel)
        titleLabel.snp.makeConstraints { make in
            make.top.equalTo(categoryLabel.snp.bottom).offset(4)
            make.centerX.equalToSuperview()
            make.leading.equalToSuperview().inset(40)
        }
    }
    
    func update(category: String, title: String) {
        categoryLabel.text = category
        titleLabel.text = title
    }
}
