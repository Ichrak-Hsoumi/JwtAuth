import { ArticleService } from './../../_services/article.service';
import { Article } from './../../model/articleModel';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-article-list',
  templateUrl: './article-list.component.html',
  styleUrls: ['./article-list.component.css']
})
export class ArticleListComponent implements OnInit {

  articles: Article[] = [];
  
  constructor(public articleService: ArticleService) { }
  
  ngOnInit(): void {
    this.articleService.list().subscribe((data: Article[])=>{
      this.articles = data;
      console.log(this.articles);
    })  
  }
  
  deletePost(id:number){
    this.articleService.delete(id).subscribe(res => {
         this.articles = this.articles.filter(item => item.id !== id);
         console.log('Post deleted successfully!');
    })
  }
}
